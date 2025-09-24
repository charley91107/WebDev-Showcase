
const characterNames = ['Goku', 'Vegeta', 'Trunks'];

const [ , , trunks ] = characterNames;


console.log({ trunks });


const returnsArrayyFn = () => {
    return ['ABC', 123] as const;
}

const [ letters, numbers ] = returnsArrayyFn();
console.log({ letters, numbers });
console.log(numbers + 100);
console.log(letters + 100);