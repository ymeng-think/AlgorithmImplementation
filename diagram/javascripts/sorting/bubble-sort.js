function BubbleSort(items) {
    this.items = items;

    this.beforeSwap = null;
    this.afterSwap = null;
}

BubbleSort.prototype = (function(){
    function sort() {
        var me = this;
        return sortInRange.call(this, 0, me.items.length);
    }

    function sortInRange(start, end) {
        var me = this;

        var i = start, j = end;
        var refreshId = setInterval(function() {
            if (me.items[j] < me.items[j - 1]) {
                swap.call(me, j - 1, j);
            }
            j--;
            if (j <= i) {
                j = end;
                i++;
            }
            if (i > end) {
                clearInterval(refreshId);
            }
        }, 10);

        return me.items;
    }

    function swap(index1, index2) {
        var me = this;

        if (me.beforeSwap) {
            me.beforeSwap(index1, index2);
        }

        me.items.swap(index1, index2);

        if (me.afterSwap) {
            me.afterSwap(index1, index2);
        }
    }

    return {
        sort: function() {
            return sort.call(this);
        }
    };
})();
