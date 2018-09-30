function SlideShow() {
    this.objs = document.querySelector('.visual_img');
    this.total = this.objs.querySelectorAll('.item');
    this.itemIdx = 0;
    this.start = undefined;
    this.left = 0;
}

SlideShow.prototype.init = function(){
    this.obj = this.total[this.itemIdx];
    this.end = this.total[this.itemIdx + 1];

    this.obj.style.position = 'absolute';
    this.end.style.position = 'absolute';

    this.obj.style.left = "0px";
    this.end.style.left = "-414px";

    for (var i = this.itemIdx + 1; i < this.total.length; i++) {
        let others = this.total[i];
        others.style.position = 'absolute';
        others.style.left = '-414px';
    }
}
SlideShow.prototype.step = function(timestamp){
    if (!this.start) {
        this.start = timestamp;
    }
    this.left += 5;
    this.end.style.left = (-414 + this.left) + 'px';
    this.obj.style.left = this.left + 'px';

    if (this.left < 414) {
        requestAnimationFrame(()=>{
            this.step();
        });
    } else {
        setTimeout(() => {
            this.start = null;
            if (this.itemIdx + 1 >= this.total.length - 1) {
                this.obj = this.total[this.itemIdx + 1];
                this.itemIdx = -1;
                this.end = this.total[this.itemIdx + 1];
            } else {
                this.itemIdx++;
                this.obj = this.total[this.itemIdx];
                this.end = this.total[this.itemIdx + 1];
            }
            this.left = 0;
            this.end.style.left = (-414 + this.left) + 'px';
            this.obj.style.left = this.left + 'px';
            requestAnimationFrame(() => {
                this.step();
            });
        }, 2000);
    }
}

SlideShow.prototype.runAnimation = function () {
    requestAnimationFrame(()=>{
        this.step()
    });
}
