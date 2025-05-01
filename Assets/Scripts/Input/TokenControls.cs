using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class TokenControls : MonoBehaviour
{
    private const float GRID_SIZE = 1.28f;

    private Vector3 _screenPoint;
    private Vector3 _offset;

    void OnMouseDown() {
        _offset = gameObject.transform.position - Camera.main.ScreenToWorldPoint(new Vector3(Input.mousePosition.x, Input.mousePosition.y, _screenPoint.z));
    }

    void OnMouseDrag() {
        Vector3 curScreenPoint = new Vector3(Input.mousePosition.x, Input.mousePosition.y, _screenPoint.z);
        Vector3 curPosition = Camera.main.ScreenToWorldPoint(curScreenPoint) + _offset;
        transform.position = curPosition;
    }

    void OnMouseUp() {
        transform.position = snapToGridSize(transform.position);
    }

    private Vector3 snapToGridSize(Vector3 position) {
        float offset = GRID_SIZE / 2;
        position.x = MathF.Round((position.x - offset) / GRID_SIZE) * GRID_SIZE + offset;
        position.y = MathF.Round((position.y - offset) / GRID_SIZE) * GRID_SIZE + offset;
        return position;
    }
}
