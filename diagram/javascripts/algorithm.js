$(function() {
    var canvas = new Canvas($("#canvas"));
    var items = generateArray(100);
    canvas.drawPillars(items);

    var sortButton = $("#sort");
    sortButton.click(function(){
        var render = new BubbleSortRender(new BubbleSort(items), canvas);
        render.start();
    });
});

var generateArray = function(max) {
    var randomization = new RandomizationInPlace();
    return randomization.randomize(SequenceGenerator.generate(max));
};