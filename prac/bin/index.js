let a = document.getElementsByClassName('manual')[0];
a.addEventListener('click', function(){
    console.log("안녕하세요?");
    let _popupUrl = "./manual/manual.html";
    let _popupNm = "팝업이름";
    window.open(_popupUrl, _popupNm);

    var me = this;
			var filePath='';
			if(target == 'manual'){
				filePath='/assets/pdf/manual.pdf';
			}else if(target=='guide'){
				filePath='/assets/pdf/guide.pdf';
			}

			if(target) {
				$('#manualView', me.element).empty().parent().removeClass('no-manual-panel').removeClass('no-search-manual-panel');
			}
			$('<iframe id="manualFrame" style="border-radius:5px;" src="/view/manual/manualFrame?file='+filePath+'"/></iframe>').appendTo($('#manualView', this.element));
})