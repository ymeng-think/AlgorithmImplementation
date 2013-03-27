$(function() {
    var canvas = $("#canvas");
    drawPillars(canvas, generateArray(100));
});

var generateArray = function(max) {
    var randomization = new RandomizationInPlace();
    var array = randomization.randomize(SequenceGenerator.generate(max));
    return array;
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