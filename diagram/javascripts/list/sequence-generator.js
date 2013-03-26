function SequenceGenerator() {}

SequenceGenerator.prototype = (function() {
    function generate(max) {
        var array = [];
        for (var i = 1; i <= max; i++) {
            array[i - 1] = i;
        }

        return array;
    }

    return {
        generate: function(max) {
            return generate(max);
        }
    };
})();
