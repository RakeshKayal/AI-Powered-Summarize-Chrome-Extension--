document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('summarizeBtn').addEventListener('click', () => processText('summarize'));
    document.getElementById('suggestBtn').addEventListener('click', () => processText('suggest'));
});

async function processText(operation) {
    try {
        // Show spinner first
        showResult('<div class="spinner"></div>');

        const [tab] = await chrome.tabs.query({ active: true, currentWindow: true });

        // Grab all current visible text from the page
        const [{ result }] = await chrome.scripting.executeScript({
            target: { tabId: tab.id },
            function: () => document.body.innerText
        });

        if (!result || result.trim() === '') {
            showResult('⚠️ No text found on this page.');
            return;
        }

        // Call backend
        const response = await fetch('http://localhost:8080/api/v1/ai/get', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ content: result, operation })
        });

        if (!response.ok) throw new Error(`API Error: ${response.status}`);

        const text = await response.text();
        showResult(text.replace(/\n/g, '<br>'));
    } catch (error) {
        showResult('❌ Error: ' + error.message);
    }
}

// Show result or spinner
function showResult(content) {
    const resultsDiv = document.getElementById('results');
    if (resultsDiv) {
        resultsDiv.innerHTML = `<div class="result-item">${content}</div>`;
    }
}
