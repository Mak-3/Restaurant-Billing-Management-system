let hamMenuIcon = document.getElementById("ham-menu");
let navBar = document.getElementById("nav-bar");
let navLinks = navBar.querySelectorAll("li");

hamMenuIcon.addEventListener("click", () => {
  navBar.classList.toggle("active");
  hamMenuIcon.classList.toggle("fa-times");
});
navLinks.forEach((navLinks) => {
  navLinks.addEventListener("click", () => {
    navBar.classList.remove("active");
    hamMenuIcon.classList.toggle("fa-times");
  });
});
const style = document.createElement('style');
    style.textContent = `
      th{
      background-color: #f446da;
      color: #ffffff;
      z-index:100;
      }
      th,td{
      padding: 12px 15px;
      }
      tr{
          border-bottom: 1px solid #dddddd;
          vertical-align: top;
      }
      tr:nth-of-type(even){
          background-color: #f3f3f3;
      }
      tr:last-of-type{
          border-bottom: 2px solid #f6f8fa;
      }
    `;
document.head.appendChild(style);
var prevOrders = document.getElementById("prevorders") 
fetch("http://localhost:9021/RestuarantBilling/apis/invoice")
    .then((response) => response.json())
    .then((json) => {
        {
            let li1="";
            json.forEach((invoice) => {
                custid = invoice.customer_id;
                li1 += `<tr>
                    <td style="display:none">${invoice.id}</td>
                    <td>${invoice.order_id}</td>
                    <td style="display:none">${invoice.customer_id}</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>${invoice.order_time}</td>
                    </tr>`;
                })        
            document.getElementById("prevorders").innerHTML = li1;
            filltable();
        }
    })
function filltable(){
    for(var i=0;i<prevOrders.rows.length;i++){
        const custnamecell = prevOrders.rows[i].cells[3];
        var custid = Number(prevOrders.rows[i].cells[2].innerHTML)
        url = "http://localhost:9021/RestuarantBilling/apis/customer/"+custid
        fetch(url)
        .then((response) => response.json())
        .then((json) => {
            var custname = json["customer_name"]   
            custnamecell.innerHTML = custname;
        })


        const foodcell = prevOrders.rows[i].cells[4];
        const invid = Number(prevOrders.rows[i].cells[0].innerHTML)
        const totalcell = prevOrders.rows[i].cells[5];
        fetch("http://localhost:9021/RestuarantBilling/apis/invoiceItem")
        .then((response) => response.json())
        .then((json) => {
            {
                let li="";
                li+=`<a data-bs-toggle="collapse" href=`+"#"+"invoice"+invid+` role="button" aria-expanded="false" aria-controls="collapseExample" id="collapse" onClick="javascript:changeText()">view more</a>`
                li+=`<div class="collapse" id=`+"invoice"+invid+` >`
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
                                li+= dish.dish_name+" X "+quantity+ `<br><br>`
                                total += dish.price*quantity;
                            }
                        })
                        }
                        // li+=`</div>`
                        foodcell.innerHTML=li;
                        totalcell.innerHTML=total;
                    })
                }
            })
        }
    })
}
}
function changeText(){
  var element = document.getElementById('collapse');
        if (element.innerHTML === 'view more'){
         element.innerHTML = 'view less';
        }
        else {
            element.innerHTML = 'view more';
        }
    }

$(':button').on('click',function(){
    var tbody = $('table tbody');
    tbody.html($('tr',tbody).get().reverse());
});

function searchOrder(){
    var input,filter,table,tr,td,i,txtvalue;
    input = document.getElementById("searchbox");
    filter = input.value;
    table = document.getElementById("prevorders");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
      td = tr[i].getElementsByTagName("td")[1];
      if (td) {
        txtvalue = td.textContent || td.innerText;
        if (txtvalue.indexOf(filter) > -1) {
          tr[i].style.display = "";
        } else {
          tr[i].style.display = "none";
        }
      }
    }
  };