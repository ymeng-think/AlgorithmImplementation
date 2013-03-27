Array.prototype.swap = function(index1, index2) {
    var temp = this[index1];
    this[index1] = this[index2];
    this[index2] = temp;
};
Array.prototype.contains = function(item) {
    return $.inArray(item, this) >= 0
}

var SequenceGenerator = {};

SequenceGenerator.generate = function(max) {
    var array = [];
    for (var i = 1; i <= max; i++) {
        array[i - 1] = i;
    }

    return array;
};
