import matplotlib.pyplot as plt
import numpy as np

# Sample data: exam scores out of 100
exam_scores = [93, 92.5, 91.5, 83, 80.5, 74, 73.5, 73.5, 68.5, 64.5, 56]

# Calculate the average score
average_score = np.mean(exam_scores)

# Create the histogram
plt.figure(figsize=(10, 6))
plt.hist(exam_scores, bins=10, color='skyblue', edgecolor='black')

# Add a vertical line for the average score
plt.axvline(average_score, color='red', linestyle='dashed', linewidth=2, label=f'Average Score: {average_score:.2f}')

# Add titles and labels
plt.title('Histogram of Exam Scores')
plt.xlabel('Scores')
plt.ylabel('Number of Students')
plt.legend()

# Show grid
plt.grid(axis='y', alpha=0.75)

# Display the histogram
plt.show()
