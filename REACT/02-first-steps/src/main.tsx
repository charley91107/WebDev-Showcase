import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import { ShoppingCartApp } from './ShoppingCartApp';

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    {/*<FirstStepsApp />*/}
    {/*<MyAwesomeApp /> */}
    <ShoppingCartApp />

  </StrictMode>,
)
