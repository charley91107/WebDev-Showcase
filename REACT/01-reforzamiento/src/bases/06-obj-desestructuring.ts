
const person = {
    name: 'Tony',
    age: 45,
    key: 'Ironman',
};

const { key, name: ironmanName, age } = person;

// const name = Person.name;
// const name = Person.age;
// const name = Person.key;
console.log({ironmanName, age, key})


interface Hero {
    name: string;
    age: number;
    key: string;
    rank?: string;
}

const useContext = ( {key, name, age, rank = 'sin rango' }: Hero ) => {
    return {
        keyName: key,
        user: {
            name,
            age,
        },
        rank: rank
    }
}

const{ 
    rank,
    keyName, 
    user 
} = useContext(person);
const { name } = user;
console.log({ rank, keyName, name });

