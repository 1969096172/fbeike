
L2Dwidget.init({
    "model": {
        jsonPath: "https://unpkg.com/live2d-widget-model-koharu@1.0.5/assets/koharu.model.json",
        "scale": 1
    },
    "display": {
        "position": "left", //看板娘的表现位置上
        "width": 150,  //小萝莉的宽度
        "height": 300, //小萝莉的高度
        "hOffset": 1080,//小萝莉的X偏移量
        "vOffset": -20//小萝莉的Y偏移量
    },
    "mobile": {
        "show": true,
        "scale": 0.5
    },
    "react": {
        "opacityDefault": 0.7,//小萝莉的透明度
        "opacityOnHover": 0.2
    }
});
