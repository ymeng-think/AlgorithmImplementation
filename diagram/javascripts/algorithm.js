$(function() {
    var canvas = new Canvas($("#canvas"));
    var maxPillarCount = parseInt($("#maxPillarCount").text());

    var items = [];

    $("#sort").click(function(){
        var render = new BubbleSortRender(new BubbleSort(items), canvas);
        render.start();
    });

    $("#pillarCount").change(function(e) {
        var pillarCount = $(e.target);
        var count = pillarCount.val();
        if (count > maxPillarCount) {
            count = maxPillarCount;
            pillarCount.val(count);
        }

        items = generateArray(count);
        canvas.redrawPillars(items);
    }).change();


});

var generateArray = function(max) {
    var randomization = new RandomizationInPlace();
    return randomization.randomize(SequenceGenerator.generate(max));
};