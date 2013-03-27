function BubbleSort(items) {
    this.items = items;
}

BubbleSort.prototype = (function(){
    function sort() {
        var me = this;
        return sortInRange(me.items, 0, me.items.length);
    }

    function sortInRange(items, start, end) {
        for (var i = start; i <= end; i++) {
            for (var j = end; j > i; j--) {
                if (items[j] < items[j - 1]) {
                    items.swap(j - 1, j);
                }
            }
        }

        return items;
    }

    return {
        sort: function() {
            return sort.call(this);
        }
    };
})();
