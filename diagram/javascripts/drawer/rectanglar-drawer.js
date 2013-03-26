function RectanglarDrawer(canvas) {
    this.canvas = canvas;
}

RectanglarDrawer.prototype = (function() {
    function rectanglar(width, height) {
        return $("<canvas/>", {'class': 'pillar'}).width(width).height(height);
    }

    function draw() {
        var me = this;
        me.canvas.append(rectanglar(10, 300));
    }

    return {
        draw: function() {
            draw.call(this);
        }
    };
})();
