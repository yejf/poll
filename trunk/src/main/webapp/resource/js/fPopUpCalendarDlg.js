function fPopUpCalendarDlg(ctrlobj)
{
    showx = event.screenX - event.offsetX - 4 - 10 ; // + deltaX;
    showy = event.screenY - event.offsetY -168; // + deltaY;
    newWINwidth = 210 + 4 + 18;

    retval = window.showModalDialog("/pgms/resource/js/Calendar.htm", "", "dialogWidth:197px; dialogHeight:210px; dialogLeft:"+showx+"px; dialogTop:"+showy+"px; status:no; directories:yes;scrollbars:no;Resizable=no; "  );
    if( retval != null ){
        ctrlobj.value = retval;
    }else{
        //alert("canceled!");
    }
}