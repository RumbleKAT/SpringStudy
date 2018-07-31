function State(){
    this.category = 0;
}

State.prototype.update = function(state) {
  var clicked_category = document.querySelector( 'ul[class="event_tab_lst tab_lst_min"]' );

    clicked_category.addEventListener('click', function(evt) {
        evt.stopPropagation();
        try{     
            state.category = parseInt(evt.target.closest('li').getAttribute('data-category'));
        }catch(e){
            console.log(e + ' miss clicked!');
        }
        state.draw();
    });
};

State.prototype.draw = function(){
    document.querySelector('a[class="anchor active"]').setAttribute('class','anchor');
    document.querySelector('li[data-category=' + '"' + this.category + '"' + '] a').setAttribute('class','anchor active');
}

var state = new State();
state.update(state);