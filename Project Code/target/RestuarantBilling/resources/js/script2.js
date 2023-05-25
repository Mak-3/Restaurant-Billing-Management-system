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
const menuid = []
const frequency =[]
const TotalAmount = []
const data = new Map();
const dishnames =[];

fetch("http://localhost:9021/RestuarantBilling/apis/invoiceItem")
        .then((response) => response.json())
        .then((json) => {
            {
                json.forEach((invoiceItem) => {
                    if(menuid.length == 0){
                        menuid.push(invoiceItem.menu_id)
                        frequency.push(invoiceItem.quantity)
                    }
                    else if(menuid.includes(invoiceItem.menu_id)){
                        var freq = menuid.indexOf(invoiceItem.menu_id)
                        frequency[freq] = frequency[freq]+invoiceItem.quantity;
                    }
                    else{
                        menuid.push(invoiceItem.menu_id)
                        frequency.push(invoiceItem.quantity);
                    }
                })
                getdishname();
                const ctx = document.getElementById('canvas');
                new Chart(ctx, {
                  type: 'bar',
                  data: {
                    labels: menuid,
                    datasets: [{
                      label: 'Total units sold',
                      data: frequency,
                      borderWidth: 1,  
                      backgroundColor: "#FFB84C"
                    }]
                  },
                  options: {
                    scales: {
                      y: {
                        beginAtZero: true
                      }
                    }
                  }
                })
            }
        })
   
async function getdishname(){
    for(var i=0;i<menuid.length;i++){
        const menuidcol = i;
        var menu_id = menuid[i];
        url = "http://localhost:9021/RestuarantBilling/apis/menu/"+menu_id
        await fetch(url)
        .then((response) => response.json())
        .then((json) => {
            var dishname = json["dish_name"]   
            menuid[menuidcol] = dishname;
            TotalAmount.push(json["price"]*frequency[menuidcol])
            dishnames.push(dishname)
        })
    }
    drawpiechart(TotalAmount,dishnames)
}
function drawpiechart(TotalAmount,dishnames){
  var revenue =0;
  for(var i=0;i<TotalAmount.length;i++){
    revenue= revenue+TotalAmount[i] 
  }
  document.getElementById('totalrev').innerHTML=revenue;
  const ctx = document.getElementById('canvas2');
                new Chart(ctx, {
                  type: 'pie',
                  data: {
                    labels: dishnames,
                    datasets: [{
                      label: 'Distributed Revenue Contribution',
                      data: TotalAmount,
                      borderWidth: 1,  
                      backgroundColor: [
                        '#F66D44',
                        '#FEAE65',
                        '#E6F69D',
                        '#AADEA7',
                        '#64C2A6',
                        '#2D87BB',
                        '#2D87BB',
                        '#F7B7A3',
                        '#9B3192',
                        '#57167E'
                      ],
                    }]
                  },
                  options: {
                    scales: {
                      y: {
                        beginAtZero: false
                      }
                    }
                  }
                })
}