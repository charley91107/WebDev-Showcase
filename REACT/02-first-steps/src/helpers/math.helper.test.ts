import { describe, expect, test } from 'vitest';
import { add, multiply, substract } from './math.helper';

describe('add', () => {
    test('should add two positive numbers', () => {
        
        const a = 1;
        const b = 2;
    
        const result = add(a, b);
    
        expect(result).toBe(a + b);
    });
    test('should add two negative numbers', () => {
        
        const a = -1;
        const b = -2;
    
        const result = add(a, b);
    
        expect(result).toBe(a + b);
    });
})

describe('substract', () => {
    test('should substract two positive numbers', () => {
        
        const a = 1;
        const b = 2;
    
        const result = substract(a, b);
    
        expect(result).toBe(a - b);
        
    })
    test('should substract two negative numbers', () => {
        
        const a = -1;
        const b = -2;
    
        const result = substract(a, b);
    
        expect(result).toBe(a - b);
    });
})

describe('multiply', () => {
    test('should multiply two positive numbers', () => {
        
        const a = 1;
        const b = 2;
    
        const result = multiply(a, b);
    
        expect(result).toBe(a * b);
        
    })
    test('should multiply two negative numbers', () => {
        
        const a = -1;
        const b = -2;
    
        const result = multiply(a, b);
    
        expect(result).toBe(a * b);
    });
})



