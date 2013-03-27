var SequenceGenerator = {};

SequenceGenerator.generate = function(max) {
    var array = [];
    for (var i = 1; i <= max; i++) {
        array[i - 1] = i;
    }

    return array;
};
