// dount gailan_jianrong
// --------------
(function () {

})();

// dount gailan_case
// --------------
(function () {

})();

// dount gailan_bianli
// --------------
(function () {

})();


// bar_jixingzhanbi
// --------------
(function () {
    var pie_chart = c3.generate({
        bindto: '#bar_jixingzhanbi',
        size: {
            height: 340,
            width: 600
        },
        data: {
            columns: [
                ['通过', 2, 3, 1, 0, 4],
                ['未通过', 4, 3, 5, 6, 2]
            ],
            type: 'bar',
            groups: [
                ['通过', '未通过']
            ]
        },

        bar: {
            width: {
                ratio: 0.5 // this makes bar width 50% of length between ticks
            }
            // or
            //width: 100 // this makes bar width 100px
        },
        axis: {
            x: {
                type: 'category',
                categories: ['cat1', 'cat2', 'cat3', 'cat4', 'cat5', 'cat6', 'cat7', 'cat8', 'cat9']
            }
        }
    });
})();

// performance_start
// --------------
(function () {
    var chart = c3.generate({
        bindto: '#performance_start',
        data: {
            columns: [
                ['启动耗时', 100, 20, 40, 60, 70]
            ],
            type: 'bar',
        },
        size: {
            width: 400,
            height: 280
        },
        /*color: {
         pattern: [Config.colors("primary", 500), Config.colors("blue-grey", 200)]
         },*/
        axis: {
            x: {
                type: 'category',
                categories: ['mobile1', 'mobile2', 'mobile3', 'mobile4', 'mobile5']
            }
        },
        bar: {
            width: {
                ratio: 0.5 // this makes bar width 50% of length between ticks
            }
        }
    });
})();

// performance_cpu
// --------------
(function () {
    var chart = c3.generate({
        bindto: '#performance_cpu',
        data: {
            columns: [
                ['启动耗时', 100, 20, 40, 60, 70]
            ],
            type: 'bar',
        },
        size: {
            width: 400,
            height: 280
        },
        /*color: {
         pattern: [Config.colors("primary", 500), Config.colors("blue-grey", 200)]
         },*/
        axis: {
            x: {
                type: 'category',
                categories: ['mobile1', 'mobile2', 'mobile3', 'mobile4', 'mobile5']
            }
        },
        bar: {
            width: {
                ratio: 0.5 // this makes bar width 50% of length between ticks
            }
        }
    });
})();

// performance_mem
// --------------
(function () {
    var chart = c3.generate({
        bindto: '#performance_mem',
        data: {
            columns: [
                ['启动耗时', 100, 20, 40, 60, 70]
            ],
            type: 'bar',
        },
        size: {
            width: 400,
            height: 280
        },
        /*color: {
         pattern: [Config.colors("primary", 500), Config.colors("blue-grey", 200)]
         },*/
        axis: {
            x: {
                type: 'category',
                categories: ['mobile1', 'mobile2', 'mobile3', 'mobile4', 'mobile5']
            }
        },
        bar: {
            width: {
                ratio: 0.5 // this makes bar width 50% of length between ticks
            }
        }
    });
})();

// performance_traffic
// --------------
(function () {
    var chart = c3.generate({
        bindto: '#performance_traffic',
        data: {
            columns: [
                ['启动耗时', 100, 20, 40, 60, 70]
            ],
            type: 'bar',
        },
        size: {
            width: 400,
            height: 280
        },
        /*color: {
         pattern: [Config.colors("primary", 500), Config.colors("blue-grey", 200)]
         },*/
        axis: {
            x: {
                type: 'category',
                categories: ['mobile1', 'mobile2', 'mobile3', 'mobile4', 'mobile5']
            }
        },
        bar: {
            width: {
                ratio: 0.5 // this makes bar width 50% of length between ticks
            }
        }
    });
})();

// performance_elect
// --------------
(function () {
    var chart = c3.generate({
        bindto: '#performance_elect',
        data: {
            columns: [
                ['启动耗时', 100, 20, 40, 60, 70]
            ],
            type: 'bar',
        },
        size: {
            width: 400,
            height: 280
        },
        /*color: {
         pattern: [Config.colors("primary", 500), Config.colors("blue-grey", 200)]
         },*/
        axis: {
            x: {
                type: 'category',
                categories: ['mobile1', 'mobile2', 'mobile3', 'mobile4', 'mobile5']
            }
        },
        bar: {
            width: {
                ratio: 0.5 // this makes bar width 50% of length between ticks
            }
        }
    });
})();