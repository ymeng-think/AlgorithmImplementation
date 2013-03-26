$(function() {
    var canvas = $("#canvas");
    drawPillars(canvas, generateArray(100));
});

var generateArray = function(max) {
    var generator = new SequenceGenerator();
    return generator.generate(max);
};

var drawPillars = function(canvas, items) {
    var horizontalMargin = 20;

    var totalWidth = canvas.width() - horizontalMargin;
    var totalHeight = canvas.height();

    var pillarWidth = totalWidth / items.length;
    var pillarHeight = totalHeight / items.length;

    var drawer = new RectanglarDrawer(canvas);
    for (var i = 0; i < items.length; i++) {
        drawer.draw(pillarWidth, pillarHeight * items[i]);
    }
};