function BubbleSortRender(sorting, canvas) {
    this.sorting = sorting;
    this.canvas = canvas;
}

BubbleSortRender.prototype = (function() {

    function start() {
        var me = this;
        var lastHighlightIndex = -1;

        me.sorting.willSwap = function(index1, index2) {
            me.canvas.normalizePillars([lastHighlightIndex]);
            me.canvas.highLightPillars([index1]);

            lastHighlightIndex = index1;
        };
        me.sorting.didSwap = function(index1, index2) {
            me.canvas.swapPillarsAt(index1, index2);
        };
        me.sorting.didSort = function() {
            me.canvas.normalizePillars([lastHighlightIndex]);
        };

        me.sorting.sort();
    }

    return {
        start: function() {
            return start.call(this);
        }
    };
})();