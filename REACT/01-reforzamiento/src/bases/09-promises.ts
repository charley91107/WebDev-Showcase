

const myPromise = new Promise( (resolve, reject) => {
    setTimeout(() => {
        //!Yo quiero  mi dinero!!
        resolve('Mi dinero ha vuelto');
       reject('mi amigo se perdio');
    }, 2000);
});

myPromise.then( (myMoneyIsBack) => {
    console.log(`Mi dinero ha vuelto ${ myMoneyIsBack }`);
}).catch( (reason) => {
    console.warn(reason);
}).finally(() => {
    console.log('Estoy seguro de que mi dinero ha volado');
});
