$(function() {
    var canvas = $("#canvas");
    var items = new Array(1, 2, 3, 4, 5, 6);

    drawPillars(canvas, items);
});

var drawPillars = function(canvas, items) {
    var horizontalMargin = 50;

    var totalWidth = canvas.width() - horizontalMargin;
    var totalHeight = canvas.height();

    var pillarWidth = totalWidth / items.length;
    var pillarHeight = totalHeight / items.length;

    var drawer = new RectanglarDrawer(canvas);
    for (var i = 0; i < items.length; i++) {
        drawer.draw(pillarWidth, pillarHeight * (i + 1));
    }
};