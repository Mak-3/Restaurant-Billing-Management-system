var incusnametag = document.getElementById('customer_name')
var incusphnotag = document.getElementById('customer_phno')
var inorderidtag = document.getElementById('order_id')
var inordertimetag = document.getElementById('order_time')
var invtotaltag = document.getElementById('total')
var invtaxestag = document.getElementById('taxes')
var invfinamounttag = document.getElementById('finalamount')
var invoicetag = document.getElementById('invoice');

fetch("http://localhost:9021/RestuarantBilling/apis/customer")
        .then((response) => response.json())
        .then((data) => {
          var custid = data.length;
          url="http://localhost:9021/RestuarantBilling/apis/customer/"+custid
          fetch(url)
        .then((response) => response.json())
        .then((data) => {
            incusnametag.innerHTML=data["customer_name"];
            incusphnotag.innerHTML=data["phone_no"]
        })
        })

        var invid;
fetch("http://localhost:9021/RestuarantBilling/apis/invoice")
        .then((response) => response.json())
        .then((data) => {
             invid = data.length;
            url="http://localhost:9021/RestuarantBilling/apis/invoice/"+invid;
            fetch(url)
        .then((res) => res.json())
        .then((info) => {
            inorderidtag.innerHTML=info["order_id"];
            inordertimetag.innerHTML=info["order_time"];
        })
    });

          url="http://localhost:9021/RestuarantBilling/apis/invoice/"+invid;
//        url="http://localhost:9021/RestuarantBilling/apis/invoice/2";
                fetch(url)
            .then((res) => res.json())
            .then((info) => {
                inorderidtag.innerHTML=info["order_id"];
                inordertimetag.innerHTML=info["order_time"]
            })




    var invItems = document.getElementById("invoice_items") 
    fetch("http://localhost:9021/RestuarantBilling/apis/invoice")
        .then((response) => response.json())
        .then((json) => {
            {
                let li1="";
                json.forEach((invoice) => {
                    if(invoice.id == json.length){
                    li1 += `<tr>
                        <td style="display:none">${invoice.id}</td>
                        <td></td>
                        <td></td>
                        </tr>`;
                    }
                    else{
                        return
                    }
                })        
                document.getElementById("invoice_items").innerHTML = li1;
                filltable();
            }
        })
    function filltable(){
        for(var i=0;i<invItems.rows.length;i++){
            const foodcell = invItems.rows[i].cells[2];
//            const invid = Number(invItems.rows[i].cells[0].innerHTML)
            const invid = 2
            fetch("http://localhost:9021/RestuarantBilling/apis/invoiceItem")
            .then((response) => response.json())
            .then((json) => {
                {
                    let li=""
                    var total = 0;
                    json.forEach((invoiceItem) => {
                        if(invoiceItem.invoice_id == invid){
                           var quantity = invoiceItem.quantity;
                           var menuid = invoiceItem.menu_id;
                           fetch("http://localhost:9021/RestuarantBilling/apis/menu")
                            .then((response) => response.json())
                            .then((json) => {
                            {
                            json.forEach((dish) => { 
                                if(dish.id == menuid){
                                    li+= `<div style="display:flex; flex-direction:row; justify-content:space-between"><div>`+dish.dish_name+" X "+quantity+`</div>`+`<div><p>`+dish.price*quantity+`</p></div>`+`</div>`
                                    total += dish.price*quantity;
                                }
                            })
                            }
                            foodcell.innerHTML = li;
                            invtotaltag.innerHTML = total+`<i class="fa fa-rupee" style="margin-left:8%" aria-hidden="true"></i>`; 
                            fetch("http://localhost:9021/RestuarantBilling/apis/taxes/1")
                            .then((response) => response.json())
                            .then((data) => {
                                var totaltax = 0;
                                totaltax =data["cgst"]+data["sgst"]+data["convinience_fee"]
                                invtaxestag.innerHTML = totaltax+`<b> %</b>`;
                                invfinamounttag.innerHTML = total+(total/100)*totaltax+`<i class="fa fa-rupee" style="margin-left:8%" aria-hidden="true"></i>`;
                            })
                        })
                    }
                })
            }
        })
    }
    }

    

