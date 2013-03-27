function Canvas(canvas) {
    this.canvas = canvas;
}

Canvas.prototype = (function() {

    function clear() {
        var me = this;
        me.canvas.empty();
    }

    function drawPillars(items) {
        var me = this;

        var horizontalMargin = 20;

        var totalWidth = me.canvas.width() - horizontalMargin;
        var totalHeight = me.canvas.height();

        var pillarWidth = totalWidth / items.length;
        var pillarHeight = totalHeight / items.length;

        var drawer = new RectanglarDrawer(me.canvas);
        for (var i = 0; i < items.length; i++) {
            drawer.draw(pillarWidth, pillarHeight * items[i]);
        }
    }

    return {
        clear: function() {
            return clear.call(this);
        },

        drawPillars: function(items) {
            return drawPillars.call(this, items);
        }
    };

})();