using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Tile : MonoBehaviour
{
    private SpriteRenderer _spriteRenderer;

    private void Awake()
    {
        _spriteRenderer = GetComponent<SpriteRenderer>();
    }

    void OnMouseEnter() {
        _spriteRenderer.color = new Color(1f, 1f, 1f, 0.5f);
    }
 
    void OnMouseExit() {
        _spriteRenderer.color = new Color(1f, 1f, 1f, 0f);
    }
}
