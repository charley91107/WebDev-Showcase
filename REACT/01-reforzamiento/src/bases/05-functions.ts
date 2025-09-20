

function greet ( name: string ): string {
    return `Hola ${ name }`;
}

const greet2 = ( name: string ): string => {
    return `Hola ${ name }`;
}


const message = greet('Carlos');
const message2 = greet2('goku');
console.log(message);
console.log(message2);