/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pepsoft.worldpainter.heightMaps;

import org.pepsoft.worldpainter.HeightMap;

/**
 * A height map which is the product of two other height maps.
 * 
 * @author pepijn
 */
public class ProductHeightMap extends CombiningHeightMap {
    public ProductHeightMap(HeightMap heightMap1, HeightMap heightMap2) {
        super(heightMap1, heightMap2);
    }

    public ProductHeightMap(String name, HeightMap heightMap1, HeightMap heightMap2) {
        super(name, heightMap1, heightMap2);
    }

    @Override
    public float getHeight(int x, int y) {
        return children[0].getHeight(x, y) * children[1].getHeight(x, y);
    }

    @Override
    public float getHeight(float x, float y) {
        return children[0].getHeight(x, y) * children[1].getHeight(x, y);
    }

    @Override
    public float getBaseHeight() {
        return children[0].getBaseHeight() * children[1].getBaseHeight();
    }
    
    @Override
    public ProductHeightMap clone() {
        ProductHeightMap clone = new ProductHeightMap(name, children[0].clone(), children[1].clone());
        clone.setSeed(getSeed());
        return clone;
    }

    private static final long serialVersionUID = 1L;
}