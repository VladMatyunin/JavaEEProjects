
function like(id) {
    var el = document.getElementById('like'+id);
    el.disable();
    $.ajax({
        url: "/SpringMVC/like",
        type: "POST",
        data: {
            id: id
        },
        success: function () {
            window.location.href = "/reg";
            return true;
        }
    })
}
function dislike(id) {
    var el = document.getElementById('dislike'+id);
    el.disable();
    $.ajax({
        url: "/SpringMVC/dislike",
        type: "POST",
        data: {
            id: id
        },
        success: function () {
            window.location.href = "/reg";
            return true;
        }
    })
}