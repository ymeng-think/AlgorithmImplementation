$(function() {
    var canvas = new Canvas($("#canvas"));
    var items = generateArray(100);
    canvas.drawPillars(items);

    var sortButton = $("#sort");
    sortButton.click(function(){
        var sorting = new BubbleSort(items);

        var lastHighlightIndex = -1;
        sorting.beforeSwap = function(index1, index2) {
            canvas.normalizePillars([lastHighlightIndex]);
            canvas.highLightPillars([index1]);

            lastHighlightIndex = index1;
        };
        sorting.afterSwap = function(index1, index2) {
            canvas.swapPillarsAt(index1, index2);
        };

        items = sorting.sort();
    });
});

var generateArray = function(max) {
    var randomization = new RandomizationInPlace();
    return randomization.randomize(SequenceGenerator.generate(max));
};