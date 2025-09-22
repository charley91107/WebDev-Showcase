

function greet ( name: string ): string {
    return `Hola ${ name }`;
}

/*const greet2 = ( name: string ): string => {
    return `Hola ${ name }`;
}*/
const greet2 = (name: string) => `Hola ${name}`;


const message = greet('Carlos');
const message2 = greet2('goku');

interface user {
    uid: string,
    name: string
}

console.log(message);
console.log(message2);

function getUser () {
    return {
        uid: 'ABC123',
        username: 'Carlos'
    };
}

const user = getUser();
console.log(user);

/*const getUSer2 = () => {
    return {
        uid: 'ABC456',
        username: 'Goku'
    };
}*/

const getUser2 = () => ({
    uid: 'ABC456',
    username: 'Goku'
});

const user2 = getUser2();
console.log(user2);

const myNumbers: number[] = [1,2,3,4,5];

// myNumbers.forEach(function (value) {
//     console.log({ value });
// });

myNumbers.forEach(console.log);

