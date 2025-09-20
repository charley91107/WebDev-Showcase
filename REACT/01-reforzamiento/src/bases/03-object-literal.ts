interface Person {
    firstName: string;
    lastName: string;
    age: number;

    address: Address
}   

interface Address {
    postalCode: string;
    city: string;
}

const ironman: Person = {
    firstName: 'Tony',
    lastName: 'Stark',
    age: 35,
    address: {
        postalCode: '123456',
        city: 'New York',
    },
};


console.log(ironman);


// const spiderman = structuredClone (ironman);

// spiderman.firstName = 'Peter';
// spiderman.lastName = 'Parker';
// spiderman.age = 22;
// spiderman.address.city = 'San Jose';
// console.log(ironman, spiderman);