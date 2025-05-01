using System;
using UnityEngine;
using UnityEngine.InputSystem;

public class CameraControls : MonoBehaviour
{
    private const float MIN_ZOOM = 1f;
    private const float ZOOM_STEP = 0.5f;

    private Vector3 _origin;
    private Camera _cam;
    private bool _isDragging;

    private void Awake() {
        _cam = Camera.main;
    }

    public void onDrag(InputAction.CallbackContext context) {
        if (context.started) {
            _origin = GetMousePosition();
        }
        _isDragging = context.started || context.performed;
    }

    public void onScroll(InputAction.CallbackContext context) {
        float value = context.ReadValue<float>();
        if (value > 0) {
            _cam.orthographicSize += ZOOM_STEP;
        }
        else if (value < 0 && _cam.orthographicSize > MIN_ZOOM) {
            _cam.orthographicSize -= ZOOM_STEP;
        }
    }

    private void LateUpdate() {
        if (_isDragging) {
            Vector3 diff = GetMousePosition() - transform.position;
            transform.position = _origin - diff;
        }
    }

    private Vector3 GetMousePosition() {
        return _cam.ScreenToWorldPoint(Mouse.current.position.ReadValue());
    }
}
