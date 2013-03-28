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

    function highLightPillars(pillarIndexes) {
        var me = this;

        $(pillarIndexes).each(function(i, element) {
            if (element >= 0) {
                var pillar = me.canvas.children().eq(element);
                pillar.addClass("highlight");
            }
        });
    }

    function normalizePillars(pillarIndexes) {
        var me = this;

        $(pillarIndexes).each(function(i, element) {
            if (element >= 0) {
                var pillar = me.canvas.children().eq(element);
                pillar.removeClass("highlight");
            }
        });
    }

    function swapPillarsAt(index1, index2) {
        var me = this;

        var pillar1 = me.canvas.children().eq(index1);
        var pillar2 = me.canvas.children().eq(index2);

        var temp = pillar1.height();
        pillar1.height(pillar2.height());
        pillar2.height(temp);
    }

    return {
        clear: function() {
            return clear.call(this);
        },

        redrawPillars: function(items) {
            clear.call(this);
            return drawPillars.call(this, items);
        },

        highLightPillars: function(pillarIndexes) {
            return highLightPillars.call(this, pillarIndexes);
        },

        normalizePillars: function(pillarIndexes) {
            return normalizePillars.call(this, pillarIndexes);
        },

        swapPillarsAt: function(index1, index2) {
            return swapPillarsAt.call(this, index1, index2);
        }
    };

})();