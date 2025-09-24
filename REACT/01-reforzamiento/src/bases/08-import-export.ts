import { heroes, type Hero, Owner } from './data/heroes.data';


const getHeroById = (id: number): Hero | undefined => {
    
    const hero = heroes.find(hero => {
        return hero.id === id
    });

    //if (!hero) {
        //throw new Error(`Hero with id ${ id } not found`);
    //}

    return hero;
}

console.log(getHeroById(7));