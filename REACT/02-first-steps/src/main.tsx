import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
//import { MyAwesomeApp } from './MyAwesomeApp';
//import { FirstStepsApp } from './FirstStepsApp';
import { ShoppingCartApp } from './ShoppingCartApp';

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    {/*<FirstStepsApp />*/}
    {/*<MyAwesomeApp /> */}
    <ShoppingCartApp />

  </StrictMode>,
)
