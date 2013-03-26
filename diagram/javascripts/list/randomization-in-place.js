function RandomizationInPlace() {}

RandomizationInPlace.prototype = (function() {
    function randomArbitary(min, max) {
        return Math.round(Math.random() * (max - min) + min);
    }

    function swap(array, index1, index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    function randomize(array) {
        for (var i = 0; i < array.length; i++) {
            var k = randomArbitary(0, array.length - 1);
            swap(array, i, k);
        }
        return array;
    }

    return {
        randomize : function(array) {
            return randomize(array);
        }
    };
})();
