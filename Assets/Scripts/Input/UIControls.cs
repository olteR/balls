using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class UIControls : MonoBehaviour
{
    [SerializeField] private GameObject _panel;

    private bool _isPanelOpen;

    private void Awake() {
        _isPanelOpen = _panel.activeSelf;
    }

    public void togglePanel() {
        _panel.SetActive(!_isPanelOpen);
        _isPanelOpen = !_isPanelOpen;
    }
}
