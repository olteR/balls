using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.EventSystems;

public class Tile : MonoBehaviour, IPointerEnterHandler, IPointerExitHandler
{
    private SpriteRenderer _spriteRenderer;

    private void Awake()
    {
        _spriteRenderer = GetComponent<SpriteRenderer>();
    }

    public void OnPointerEnter(PointerEventData pointerEventData) {
        _spriteRenderer.color = new Color(1f, 1f, 1f, 0.5f);
    }
 
    public void OnPointerExit(PointerEventData pointerEventData) {
        _spriteRenderer.color = new Color(1f, 1f, 1f, 0f);
    }
}
