var SortSpeed = {};

SortSpeed.get = function(level) {
    return Math.pow(10, 3 - level);
};