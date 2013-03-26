function RectanglarDrawer(canvas) {
    this.canvas = canvas;
}

RectanglarDrawer.prototype = (function() {
    function rectanglar(width, height) {
        return $("<canvas/>", {'class': 'pillar'}).width(width).height(height);
    }

    function draw(width, height) {
        var me = this;
        me.canvas.append(rectanglar(width - 2, height));
    }

    return {
        draw: function(width, height) {
            draw.call(this, width, height);
        }
    };
})();
