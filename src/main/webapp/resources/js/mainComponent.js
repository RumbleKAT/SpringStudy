var state = {
    category_idx: 0,
    product_idx: 0,
    categories: {}
}

function MainComponent() {
    this.categories = undefined; //full data of category
    this.event_lst_txt = document.querySelector('.event_lst_txt');
    this.more_btn = document.querySelector(".more");
    this.top_btn = document.querySelector(".gototop");
    this.clicked_category = document.querySelector('ul[class="event_tab_lst tab_lst_min"]');
}

MainComponent.prototype.categoryInit = function () {
    ajaxUpdate('GET', 'http://localhost:8080/reservation/categories')
        .then(result => {
            state.categories = result;
            this.eventUpdate();
            this.listUpdate(state.category_idx, state.product_idx);
        });
}

MainComponent.prototype.promotionInit = function () {
    ajaxUpdate('GET', 'http://localhost:8080/reservation/promotions')
        .then(result => {
            let templateHTML = document.querySelector("#promotionItem").innerHTML;
            let visual_img = document.querySelector('.visual_img');
            let resultHTML = "";

            (function loop(i) {
                if (i == result.items.length) {
                    let slider = new SlideShow();
                    slider.init();
                    slider.runAnimation();
                }else if (i < result.items.length)
                    new Promise((resolve) => {
                        let tempHTML = templateHTML.replace("${productId}", result.items[i].productId)
                            .replace("${productImageId}", result.items[i].productImageId);

                        let temp_div = document.createElement('div');
                        temp_div.innerHTML = tempHTML;

                        let img_url = temp_div.querySelector('li').style.backgroundImage;
                        let start = img_url.indexOf('"');
                        let end = img_url.lastIndexOf('"');
                        img_url = img_url.slice(start + 1, end);

                        ajaxUpdate('GET', img_url)
                            .then(result => {
                                temp_div.querySelector('li').style.backgroundImage = 'url(' + result.src + ')';
                                if (i != 0) {
                                    temp_div.querySelector('li').style.backgroundImage = 'url(' + result.src + ')';
                                }
                                resultHTML = temp_div.innerHTML;
                                visual_img.innerHTML += resultHTML;
                                resolve();
                            })
                    }).then(loop.bind(null, i + 1))
            })(0);
        });
}

MainComponent.prototype.btnInit = function () {
    this.more_btn.addEventListener("click", () => {
        this.listUpdate(state.category_idx, state.product_idx);
    });

    this.top_btn.addEventListener("click", () => {
        if (navigator.appName === "Safari") {
            document.body.scrollTop = 0;
        } else {
            document.documentElement.scrollTop = 0;
        }
    });
};

MainComponent.prototype.categoryUpdate = function () {
    this.clicked_category.addEventListener("click", evt => {
        evt.stopPropagation();
        try {
            state.category_idx = parseInt(
                evt.target.closest("li").getAttribute("data-category")
            );
        } catch (e) {
            console.log(e + " miss clicked!");
        }
        this.draw();
    });
};

MainComponent.prototype.draw = function () {
    let lst_event_box = document.querySelectorAll(".lst_event_box");
    lst_event_box.forEach(element => {
        element.innerHTML = ""
    });

    document.querySelector('a[class="anchor active"]').setAttribute('class', 'anchor');
    document.querySelector('li[data-category=' + '"' + state.category_idx + '"' + '] a').setAttribute('class', 'anchor active');
    state.product_idx = 0;
    this.listUpdate(state.category_idx, state.product_idx);

    this.eventUpdate();
}

MainComponent.prototype.eventUpdate = function () {
    let pink_span = this.event_lst_txt.querySelector(".pink");

    let sum = 0;
    state.categories.items.forEach(element => {
        if (state.category_idx === 0) {
            sum += element.count;
        } else {
            if (state.category_idx === element.id) {
                sum = element.count;
            }
        }
    });
    pink_span.innerText = sum + "개";
};

MainComponent.prototype.listUpdate = function (category, index) {
    var url = undefined;
    if (category === 0) {
        url = 'http://localhost:8080/reservation/products?start=' + index
    } else {
        url = 'http://localhost:8080/reservation/products?categoryId=' + category + '&start=' + index;
    }
    ajaxUpdate('GET', url)
        .then(result => {
            let resultHTML = "";
            let templateHTML = document.querySelector("#itemList").innerHTML;
            (function loop(i) {
                if (i == result.products.length) {
                    if(result.products.length == 0){
                        document.querySelector(".more").innerHTML = "";
                    }else{
                        state.product_idx += result.products.length;
                    }
                } else if (i < result.products.length)
                    new Promise((resolve) => {
                        resultHTML = templateHTML
                            .replace(/\${id}/g, result.products[i].id)
                            .replace(/\${description}/g, result.products[i].description)
                            .replace("${placeName}", result.products[i].placeName)
                            .replace("${content}", result.products[i].content);

                        let temp_div = document.createElement('div');
                        temp_div.innerHTML = resultHTML;
                        ajaxUpdate('GET', 'http://localhost:8080/reservation/productImages/' + result.products[i].id + '?type=th')
                            .then(result => {
                                temp_div.querySelector('img').src = result.src;
                                let lst_event_box = document.querySelectorAll(".lst_event_box");
                                if ((i + 1) % 2 == 1) {
                                    lst_event_box[0].innerHTML += temp_div.innerHTML;
                                } else {
                                    lst_event_box[1].innerHTML += temp_div.innerHTML;
                                }
                                resolve();
                            })
                    }).then(loop.bind(null, i + 1))
            })(0);
        });
}

function ajaxUpdate(type, url) {
    return new Promise(function (resolve) {
        let xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                return resolve(JSON.parse(this.responseText));
            }
        };
        xhttp.open(type, url, true);
        xhttp.send();
    })
};