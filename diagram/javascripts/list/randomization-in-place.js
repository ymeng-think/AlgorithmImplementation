function RandomizationInPlace() {}

RandomizationInPlace.prototype = (function() {
    function randomArbitary(min, max) {
        return Math.round(Math.random() * (max - min) + min);
    }

    function randomize(array) {
        for (var i = 0; i < array.length; i++) {
            var k = randomArbitary(0, array.length - 1);
            array.swap(i, k);
        }
        return array;
    }

    return {
        randomize : function(array) {
            return randomize(array);
        }
    };
})();
