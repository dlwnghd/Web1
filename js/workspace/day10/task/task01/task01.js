let $tempTr;
let tempText;

function confirm(){
    // const input = document.getElementById("input").value;
    const input = $("#input").val();
    // const trs = document.querySelectorAll("tbody tr");
    const $trs = $("tbody tr");
    let check = false;

    if($tempTr){
        // tempTr.style.background = "#fff";
        $tempTr.css("background", "#fff");
        // tempTr.firstElementChild.innerHTML = tempText;
        $tempTr.children().first().text(tempText);
    }

    $.each($trs, function(i, tr){
        let $td = $(tr).children().first();
        if($td.text() == input){
            $tempTr = $(tr);
            tempText = $td.text();

            $(tr).css("background", "#ef5350");
            $td.text("★" + input);
            check = true;
        }
    });

    // trs.forEach(tr => {
    //     let td = tr.firstElementChild;
    //     if(td.innerHTML == input){
    //         tempTr = tr;
    //         tempText = td.innerHTML;

    //         tr.style.background = "#ef5350";
    //         td.innerHTML = "★" + input;
    //         check = true;
    //     }
    // });

    if(!check){
        alert("다시 시도해주세요.");
    }
}