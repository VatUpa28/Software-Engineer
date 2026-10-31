using UnityEngine;

public class PlatformGenerator : MonoBehaviour
{
    [SerializeField] private GameObject platformPrefab;
    [SerializeField] private float firstGeneratedX = 13f;
    [SerializeField] private float platformSpacing = 5f;

    [SerializeField] private float minY = -1.75f;
    [SerializeField] private float maxY = 1.75f;

    private float _nextX;

    void Start()
    {
        _nextX = firstGeneratedX;
    }

    private void OnTriggerEnter2D(Collider2D other)
    {
        if (!other.CompareTag("Spawn"))
        {
            return;
        }

        float nextY = Random.Range(minY, maxY);
        Vector3 nextPosition = new Vector3(_nextX, nextY, 0f);

        Instantiate(platformPrefab, nextPosition, Quaternion.identity);

        _nextX += platformSpacing;
    }
}