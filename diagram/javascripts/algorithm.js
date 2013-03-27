$(function() {
    var canvas = new Canvas($("#canvas"));
    var items = generateArray(100);
    canvas.drawPillars(items);

    var sortButton = $("#sort");
    sortButton.click(function(){
        var sorting = new BubbleSort(items);
        items = sorting.sort();
        canvas.clear();
        canvas.drawPillars(items);
    });
});

var generateArray = function(max) {
    var randomization = new RandomizationInPlace();
    return randomization.randomize(SequenceGenerator.generate(max));
};