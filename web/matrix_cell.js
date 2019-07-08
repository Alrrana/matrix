import { Component } from '@angular/core';

@Component({
    selector: 'my-app',
    template: `<input onkeyup="inpA()" type="text" col="' + index + '" row="' + i + '" placeholder="_">`
})
export class AppComponent {
    name= '';
}