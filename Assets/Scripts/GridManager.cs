using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GridManager : MonoBehaviour
{
    private const float GRID_SIZE = 1.28f;

    [SerializeField] private int _cols;
    [SerializeField] private int _rows;

    [SerializeField] private GameObject _tilePrefab;
 
    private Dictionary<Vector2, GameObject> _tiles;
 
    void Start() {
        GenerateGrid();
    }
 
    void GenerateGrid() {
        _tiles = new Dictionary<Vector2, GameObject>();
        for (int i = 0; i < _cols; i++) {
            for (int j = 0; j < _rows; j++) {
                GameObject spawnedTile = Instantiate(_tilePrefab);
                spawnedTile.name = $"Tile {i} {j}";
                spawnedTile.transform.parent = gameObject.transform;
                spawnedTile.transform.position = new Vector3(_tilePrefab.transform.position.x + i * GRID_SIZE, _tilePrefab.transform.position.y - j * GRID_SIZE, -1);
                _tiles[new Vector2(i, j)] = spawnedTile;
            }
        }
    }
 
    public GameObject GetTileAtPosition(Vector2 pos) {
        if (_tiles.TryGetValue(pos, out var tile)) return tile;
        return null;
    }
}

