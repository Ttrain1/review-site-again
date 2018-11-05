const addTagButton = document.querySelector('button')
const p = document.querySelector('.tags')
const original = p.innerHTML;
addTagButton.addEventListener('click', () => {
	const input = document.querySelector('.taggyTag')
	var xhttp = new XMLHttpRequest()
	// Sets behavior for when the AJAX request is complete
	console.log(xhttp);
	xhttp.onreadystatechange = function() {
		// Checks the ready state and http status code
		if (this.readyState == 4 && this.status == 200) {
			// Typical action to be performed when the document is ready:
			console.log(JSON.parse(this.responseText))
			p.innerHTML = original;
			JSON.parse(this.responseText).forEach(tag =>{
				p.innerHTML = `
					<a href = "/tag/${tag.id}">${tag.tagName}</a> 
				` + p.innerHTML;
			})
		}
	}
	xhttp.open('POST', `/api/reviews/${window.location.pathname.split('/')[2]}/tags/add`, true)
	const body = JSON.stringify({
				tagName: input.value,
			})
	xhttp.send(body)
})


 fetch(`/api/reviews/${window.location.pathname.split('/')[2]}`, {
 				method: 'get'
 			})
 			.then(res => res.json())
 			.then(data => {
 				data.forEach(tag =>{
 				p.innerHTML = p.innerHTML + `
				<a href = "/tag/${tag.id}" class="a${tag.id}">${tag.tagName}</a> <button class="button${tag.id}">X</button>	`; 
				document.querySelector(`.button${tag.id}`).addEventListener('click', () => {
				fetch(`/api/review/${window.location.pathname.split('/')[2]}/tags/remove`, {
				method: 'POST',
				body:	JSON.stringify({
				tagName: tag.tagName
				})
				}).then(() => {
				document.querySelector(`.a${tag.id}`).remove();
				document.querySelector(`.button${tag.id}`).remove();
			})
		})
	})
})


