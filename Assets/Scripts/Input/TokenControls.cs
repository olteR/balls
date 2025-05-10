using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class TokenControls : MonoBehaviour
{
    private const float GRID_SIZE = 1.28f;

    private Vector3 _screenPoint;
    private Vector3 _offset;
    private LineRenderer _lineRenderer;

    private void Awake()
    {
        _lineRenderer = GetComponent<LineRenderer>();
    }

    void OnMouseDown() {
        _offset = gameObject.transform.position - Camera.main.ScreenToWorldPoint(new Vector3(Input.mousePosition.x, Input.mousePosition.y, _screenPoint.z));
        _lineRenderer.positionCount = 2;
        _lineRenderer.SetPosition(0, new Vector3(gameObject.transform.position.x, gameObject.transform.position.y, 0));
        _lineRenderer.SetPosition(1, new Vector3(gameObject.transform.position.x, gameObject.transform.position.y, 0));
    }

    void OnMouseDrag() {
        Vector3 currScreenPoint = new Vector3(Input.mousePosition.x, Input.mousePosition.y, _screenPoint.z);
        Vector3 currPosition = Camera.main.ScreenToWorldPoint(currScreenPoint) + _offset;
        transform.position = currPosition;
        if (Input.GetMouseButtonDown(1)) {
            _lineRenderer.SetPosition(_lineRenderer.positionCount - 1, snapToGridSize(new Vector3(currPosition.x, currPosition.y, 0)));
            _lineRenderer.positionCount++;
        }
        _lineRenderer.SetPosition(_lineRenderer.positionCount - 1, new Vector3(currPosition.x, currPosition.y, 0));
    }

    void OnMouseUp() {
        transform.position = snapToGridSize(transform.position);
        _lineRenderer.positionCount = 0;
    }

    private Vector3 snapToGridSize(Vector3 position) {
        float offset = GRID_SIZE / 2;
        position.x = MathF.Round((position.x - offset) / GRID_SIZE) * GRID_SIZE + offset;
        position.y = MathF.Round((position.y - offset) / GRID_SIZE) * GRID_SIZE + offset;
        return position;
    }
}
